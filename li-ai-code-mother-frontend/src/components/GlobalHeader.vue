<script setup lang="ts">
import { ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import type { ItemType, MenuProps } from 'ant-design-vue'

const router = useRouter()
const route = useRoute()

/**
 * 导航菜单配置（在这里增删菜单项即可）
 */
const menuItems: ItemType[] = [
    { key: '/', label: '首页' },
    { key: '/about', label: '关于' },
]

// 当前选中的菜单项，与路由同步
const selectedKeys = ref<string[]>([route.path])
watch(
    () => route.path,
    (path) => {
        selectedKeys.value = [path]
    },
)


// 处理菜单点击
const handleMenuClick: MenuProps['onClick'] = (e) => {
    const key = e.key as string
    selectedKeys.value = [key]
    // 跳转到对应页面
    if (key.startsWith('/')) {
        router.push(key)
    }
}


const handleLogin = () => {
    // TODO: 后续接入登录功能
}
</script>

<template>
    <div class="global-header">
        <div class="header-left">
            <div class="logo" @click="router.push('/')">
                <img class="logo-img" src="@/assets/logo.png" alt="logo" />
                <span class="logo-title">Li AI 母体</span>
            </div>
            <a-menu
                v-model:selectedKeys="selectedKeys"
                class="header-menu"
                mode="horizontal"
                :items="menuItems"
                :selectable="true"
                @click="handleMenuClick"
            />

        </div>
        <div class="header-right">
            <a-button type="primary" @click="handleLogin">登录</a-button>
        </div>
    </div>
</template>

<style scoped>
.global-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 16px;
    max-width: 1440px;
    margin: 0 auto;
    padding: 0 24px;
}

.header-left {
    display: flex;
    align-items: center;
    flex: 1;
    min-width: 0;
}

.logo {
    display: flex;
    align-items: center;
    gap: 8px;
    margin-right: 32px;
    cursor: pointer;
    flex-shrink: 0;
}

.logo-img {
    width: 32px;
    height: 32px;
    border-radius: 8px;
}

.logo-title {
    font-size: 18px;
    font-weight: 600;
    color: rgba(0, 0, 0, 0.88);
    white-space: nowrap;
}

.header-menu {
    flex: 1;
    min-width: 0;
    border-bottom: none;
}

.header-right {
    display: flex;
    align-items: center;
    flex-shrink: 0;
}

/* 响应式：小屏时隐藏网站标题 */
@media (max-width: 640px) {
    .logo-title {
        display: none;
    }

    .logo {
        margin-right: 16px;
    }
}
</style>
