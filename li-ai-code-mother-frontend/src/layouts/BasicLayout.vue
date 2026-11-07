<script setup lang="ts">
import { RouterView } from 'vue-router'
import GlobalHeader from '@/components/GlobalHeader.vue'
import GlobalFooter from '@/components/GlobalFooter.vue'
</script>

<template>
  <a-layout class="basic-layout">
    <!-- 上：全局导航栏 -->
    <a-layout-header class="basic-layout-header">
      <GlobalHeader />
    </a-layout-header>

    <!-- 中：内容区域，根据路由切换页面 -->
    <a-layout-content class="basic-layout-content">
      <RouterView />
    </a-layout-content>

    <!-- 下：全局版权信息 -->
    <a-layout-footer class="basic-layout-footer">
      <GlobalFooter />
    </a-layout-footer>
  </a-layout>
</template>

<style scoped>
.basic-layout {
  min-height: 100vh;
}

.basic-layout-header {
  display: flex;
  align-items: center;
  height: 64px;
  padding: 0;
  background: #fff;
  border-bottom: 1px solid rgba(5, 5, 5, 0.06);
}

.basic-layout-content {
  flex: 1;
  max-width: 1440px;
  width: 100%;
  margin: 0 auto;
  padding: 24px;
  background: #f5f5f5;
}

.basic-layout-footer {
  padding: 0;
  background: #fff;
  border-top: 1px solid rgba(5, 5, 5, 0.06);
}
</style>
