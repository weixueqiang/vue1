<template>
<el-tree
  :data="data2"
  show-checkbox
  node-key="id"

  :default-expanded-keys="[2, 3]"
  :default-checked-keys="[5]"
  :props="defaultProps">
</el-tree>
</template>
<script>
  export default {
    data() {
      return {
        data2: [{
          id: 1,
          label: '一级 1',
          children: [{
            id: 4,
            label: '二级 1-1',
            children: [{
              id: 9,
              label: '三级 1-1-1'
            }, {
              id: 10,
              label: '三级 1-1-2'
            }]
          }]
        }],
        defaultProps: {
          children: 'children',
          label: function (data,node) {
            return data.label+'--';
          }
        }
      };
    },
    methods:{
        names(data, node){
            return 'dfsfs';
        },
        label(data, node){
           return data.label+'--';
        }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
