<template>
<el-tree
  :data="data"
  show-checkbox
  node-key="id"
  @node-click="tclick"
  :default-expanded-keys="[2, 3]"
  :default-checked-keys="[5]"
  :props="defaultProps">
</el-tree>
</template>
<script>
  export default {
    data() {
      return {
        data: [],
        defaultProps: {
          children: 'children',
          label:'name'
        }
      };
    },
    methods:{
      tclick(){
            console.log('lllllllllllllllllll');
      },
      getTree(){
          this.$http.get('resource/list').then(obj=>{
              let body = obj.body;
              if(body.succee){

              }else{

              }
          })
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
