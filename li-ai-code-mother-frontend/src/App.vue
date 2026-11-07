<script setup lang="ts">
import BasicLayout from '@/layouts/BasicLayout.vue'
import { healthControllerGetHealth } from '@/api/healthController.ts'

healthControllerGetHealth().then((res) => {
  console.log(res)
})

</script>

<template>
  <BasicLayout />
</template>
