<template>
  <div id="app">
    <!-- 头部 -->
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">vue-element</div></el-col>
    </el-row>
    <el-switch
      v-model="value2"
      active-color="#13ce66"
      inactive-color="#ff4949">
    </el-switch>
    <h1>{{msg}}</h1>
    <!-- 中间组件 router-view-->
    <!-- 底部是router-link -->

    <div id="foot">
      <el-tabs tab-position="bottom">
        <router-link to="/"><el-tab-pane label="用户管理" name="first">用户管理 </el-tab-pane></router-link>
        <!--<router-link to=""> <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane></router-link>-->


      <!--  <el-tab-pane label="角色管理" name="third"> <router-link to="">角色管理</router-link></el-tab-pane>
        <el-tab-pane label="定时任务补偿" name="fourth"> <router-link to="">定时任务补偿</router-link></el-tab-pane>-->
      </el-tabs>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return {msg:'123',value2:true}
  }
}
</script>

<style scoped>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0px;
  padding: 0px;
}
.el-row {
  margin-bottom: 20px;

}
.el-col {
  border-radius: 4px;
  text-align: center;
}
.bg-purple-dark {
  background: #99a9bf;
  height: 60px;
  font-size: 30px;
  line-height: 60px;
}
#foot{
  position: fixed;
  bottom: 0px;
  border: 1px solid red;
}
</style>
