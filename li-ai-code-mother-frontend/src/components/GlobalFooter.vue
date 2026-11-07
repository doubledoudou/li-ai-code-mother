<template>
  <div class="global-footer">
    <span class="copyright">Li AI 母体 © {{ new Date().getFullYear() }} · Powered by Vue3 + Ant Design Vue</span>
  </div>
</template>

<style scoped>
.global-footer {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 16px 24px;
  background: #fff;
}

.copyright {
  color: rgba(0, 0, 0, 0.45);
  font-size: 14px;
  text-align: center;
}
</style>
