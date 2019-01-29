<template>
  <div >

    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1"><router-link tag="div" to="/center/hello" >处理中心</router-link></el-menu-item>
      <el-menu-item index="2"><router-link tag="div" to="/center/user"  >用户中心</router-link></el-menu-item>
      <el-menu-item index="5"><router-link tag="div" to="/center/form" >表单测试</router-link></el-menu-item>
      <el-menu-item index="3" disabled>消息中心</el-menu-item>
      <el-menu-item index="4"><a href="https://www.ele.me" target="_blank" >订单管理</a></el-menu-item>
    </el-menu>

    <router-view></router-view>

  </div>
</template>

<script>
  //  import test from './js/test.js'
  export default {
    data() {
      return {
        activeIndex: '1',
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style scoped>
  #hand .router-link-active{
    height: 60px;
  }
  .el-menu-item{
    padding: 0px;
    width: 80px;
    text-align: center;
  }
</style>
