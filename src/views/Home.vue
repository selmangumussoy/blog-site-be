<template>
  <div class="grid grid-cols-1 md:grid-cols-3 gap-6">
    <!-- Main content -->
    <div class="col-span-2">
      <div class="space-y-6">
        <!-- Post creation card -->
        <div class="bg-white shadow rounded-lg p-4">
          <div class="flex space-x-4">
            <img class="h-10 w-10 rounded-full" :src="userStore.profilePicture || 'https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg'" alt="" />
            <div class="flex-1">
              <textarea
                v-model="newPostContent"
                rows="3"
                class="block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
                placeholder="What's on your mind?"
              ></textarea>
              <div class="mt-3 flex items-center justify-between">
                <div class="flex items-center space-x-2">
                  <button @click="triggerImageUpload" class="text-gray-500 hover:text-gray-700">
                    <PhotoIcon class="h-5 w-5" />
                  </button>
                  <input
                    ref="fileInput"
                    type="file"
                    accept="image/*"
                    class="hidden"
                    @change="handleImageUpload"
                  />
                </div>
                <button 
                  @click="createPost"
                  :disabled="!newPostContent.trim()"
                  class="inline-flex items-center px-4 py-2 border border-transparent text-sm font-medium rounded-md shadow-sm text-white bg-indigo-600 hover:bg-indigo-700 disabled:opacity-50"
                >
                  Share
                </button>
              </div>
              <div v-if="selectedImage" class="mt-2">
                <img :src="selectedImage" alt="Selected" class="max-h-40 rounded" />
              </div>
            </div>
          </div>
        </div>

        <!-- Posts feed -->
        <div v-if="postStore.loading" class="text-center py-4">
          Loading posts...
        </div>
        <div v-else class="space-y-6">
          <article v-for="post in postStore.posts" :key="post.id" class="bg-white shadow rounded-lg">
            <div class="p-4">
              <div class="flex space-x-3">
                <img class="h-10 w-10 rounded-full" :src="post.author.avatar" alt="" />
                <div class="flex-1 min-w-0">
                  <p class="text-sm font-medium text-gray-900">{{ post.author.name }}</p>
                  <p class="text-sm text-gray-500">{{ formatDate(post.timestamp) }}</p>
                </div>
                <div class="relative">
                  <button @click="togglePostMenu(post.id)" class="text-gray-400 hover:text-gray-600">
                    <EllipsisHorizontalIcon class="h-5 w-5" />
                  </button>
                  <div v-if="activePostMenu === post.id" class="absolute right-0 mt-2 w-48 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5">
                    <div class="py-1">
                      <button @click="sharePost(post)" class="block w-full px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Share</button>
                      <button @click="quotePost(post)" class="block w-full px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Quote</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="mt-4 text-sm text-gray-900">{{ post.content }}</div>
              <div v-if="post.image" class="mt-4">
                <img :src="post.image" alt="" class="rounded-lg" />
              </div>
            </div>
            <div class="border-t border-gray-200 px-4 py-3">
              <div class="flex space-x-4">
                <button @click="toggleLike(post)" class="flex items-center text-gray-500 hover:text-gray-900">
                  <HeartIcon :class="['h-5 w-5 mr-1', { 'text-red-500 fill-current': post.liked }]" />
                  {{ post.likes }}
                </button>
                <button @click="toggleComments(post)" class="flex items-center text-gray-500 hover:text-gray-900">
                  <ChatBubbleLeftIcon class="h-5 w-5 mr-1" />
                  {{ post.comments }}
                </button>
                <button @click="sharePost(post)" class="flex items-center text-gray-500 hover:text-gray-900">
                  <ShareIcon class="h-5 w-5 mr-1" />
                  Share
                </button>
              </div>
              <div v-if="post.showComments" class="mt-4">
                <div class="space-y-4">
                  <div v-for="comment in post.commentList" :key="comment.id" class="flex space-x-3">
                    <img class="h-8 w-8 rounded-full" :src="comment.author.avatar" alt="" />
                    <div class="flex-1 bg-gray-50 rounded-lg px-4 py-2">
                      <div class="text-sm font-medium text-gray-900">{{ comment.author.name }}</div>
                      <div class="text-sm text-gray-700">{{ comment.content }}</div>
                    </div>
                  </div>
                </div>
                <div class="mt-4 flex space-x-3">
                  <img class="h-8 w-8 rounded-full" :src="userStore.profilePicture" alt="" />
                  <div class="flex-1">
                    <input
                      v-model="newComments[post.id]"
                      type="text"
                      class="block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
                      placeholder="Write a comment..."
                      @keyup.enter="addComment(post)"
                    />
                  </div>
                </div>
              </div>
            </div>
          </article>
        </div>
      </div>
    </div>

    <!-- Sidebar -->
    <div class="hidden md:block">
      <div class="bg-white shadow rounded-lg p-4">
        <h2 class="text-lg font-medium text-gray-900">Suggested Users</h2>
        <div class="mt-6 space-y-4">
          <div v-for="user in suggestedUsers" :key="user.id" class="flex items-center space-x-3">
            <img class="h-8 w-8 rounded-full" :src="user.avatar" alt="" />
            <div class="flex-1 min-w-0">
              <p class="text-sm font-medium text-gray-900">{{ user.name }}</p>
              <p class="text-sm text-gray-500">{{ user.username }}</p>
            </div>
            <button 
              @click="followUser(user)"
              class="text-sm text-indigo-600 hover:text-indigo-900"
            >
              {{ user.following ? 'Unfollow' : 'Follow' }}
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { format } from 'date-fns'
import { 
  HeartIcon, 
  ChatBubbleLeftIcon, 
  ShareIcon, 
  PhotoIcon,
  EllipsisHorizontalIcon 
} from '@heroicons/vue/24/outline'
import { useUserStore } from '../stores/user'
import { usePostStore } from '../stores/posts'

const userStore = useUserStore()
const postStore = usePostStore()

const newPostContent = ref('')
const selectedImage = ref('')
const fileInput = ref<HTMLInputElement | null>(null)
const activePostMenu = ref<string | null>(null)
const newComments = ref<Record<string, string>>({})

const suggestedUsers = ref([
  {
    id: 1,
    name: 'Alice Johnson',
    username: '@alice',
    avatar: 'https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg',
    following: false
  },
  {
    id: 2,
    name: 'Bob Wilson',
    username: '@bob',
    avatar: 'https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg',
    following: false
  }
])

onMounted(async () => {
  await postStore.fetchPosts()
})

function formatDate(date: string | Date) {
  return format(new Date(date), 'MMM d, yyyy')
}

function triggerImageUpload() {
  fileInput.value?.click()
}

function handleImageUpload(event: Event) {
  const file = (event.target as HTMLInputElement).files?.[0]
  if (file) {
    const reader = new FileReader()
    reader.onload = (e) => {
      selectedImage.value = e.target?.result as string
    }
    reader.readAsDataURL(file)
  }
}

async function createPost() {
  if (!newPostContent.value.trim()) return
  
  try {
    await postStore.createPost(newPostContent.value, selectedImage.value)
    newPostContent.value = ''
    selectedImage.value = ''
  } catch (error) {
    console.error('Error creating post:', error)
  }
}

function togglePostMenu(postId: string) {
  activePostMenu.value = activePostMenu.value === postId ? null : postId
}

function toggleLike(post: any) {
  post.liked = !post.liked
  post.likes += post.liked ? 1 : -1
}

function toggleComments(post: any) {
  post.showComments = !post.showComments
}

function addComment(post: any) {
  const comment = newComments.value[post.id]
  if (!comment?.trim()) return

  post.commentList = post.commentList || []
  post.commentList.push({
    id: Date.now(),
    content: comment,
    author: {
      name: userStore.user?.name || 'Anonymous',
      avatar: userStore.profilePicture
    }
  })
  post.comments++
  newComments.value[post.id] = ''
}

function sharePost(post: any) {
  // Implement sharing functionality
  console.log('Sharing post:', post)
}

function quotePost(post: any) {
  newPostContent.value = `Quoting @${post.author.name}:\n"${post.content}"\n\n`
  activePostMenu.value = null
  window.scrollTo({ top: 0, behavior: 'smooth' })
}

function followUser(user: any) {
  user.following = !user.following
}
</script>