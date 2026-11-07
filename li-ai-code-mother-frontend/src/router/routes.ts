import type { RouteRecordRaw } from 'vue-router'
import HomePage from '../pages/HomePage.vue'

/**
 * 路由配置：每个 path 对应一个 component
 * 新增页面时在这里添加一项即可
 */
const routes: RouteRecordRaw[] = [
  {
    path: '/',
    name: 'home',
    component: HomePage,
  },
  {
    path: '/about',
    name: 'about',
    // 路由级懒加载：访问该页面时才加载对应 chunk（About.[hash].js）
    component: () => import('../pages/AboutPage.vue'),
  },
]

export default routes
