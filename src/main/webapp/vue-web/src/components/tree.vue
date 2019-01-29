<template>
  <div>
    <div id="left">
      <el-tree
        :data="data2"
        show-checkbox
        node-key="id"

        :props="defaultProps">
      </el-tree>
    </div>
  </div>

</template>
<script>
  export default {
    data() {
      return {
        data2: [
        ],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      }
    },
    created(){
      this.list();
    },
    methods:{
        list(){
          this.$http.get('resource/list').then(obj=>{
            let body = obj.body;
            if(body.succee){
              this.data2=body.data;
            }else{
              this.$message.error(body.msg);
            }
          })
        },
        add(){
          
        },
        get(){
          console.log('fdsf');
        }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>



</style>
