    package com.example.blogsitebe.domain.platform.message.web;

    import com.example.blogsitebe.domain.platform.chat.api.ChatService;
    import com.example.blogsitebe.domain.platform.message.api.MessageDto;
    import com.example.blogsitebe.domain.platform.message.api.MessageService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.messaging.handler.annotation.MessageMapping;
    import org.springframework.messaging.simp.SimpMessagingTemplate;
    import org.springframework.stereotype.Controller;

    @Controller
    @RequiredArgsConstructor
    public class MessageWSController {

        private final MessageService messageService;
        private final ChatService chatService;
        private final SimpMessagingTemplate messagingTemplate;

        @MessageMapping("/message.send")
        public void sendMessage(MessageWebSocketRequest req) {
            System.out.println(req);

            // 1) Mesajı DB’ye kaydet
            MessageDto savedMessage = messageService.create(req.toMessageDto());

            // 2) Chat kaydını güncelle (lastMessage)
            chatService.updateLastMessage(
                    savedMessage.getSenderId(),
                    savedMessage.getReceiverId(),
                    savedMessage.getContent()
            );

            // 3) Mesajı karşı tarafa gönder
            messagingTemplate.convertAndSendToUser(
                    savedMessage.getReceiverId(),
                    "/queue/private",
                    savedMessage
            );
        }
    }
