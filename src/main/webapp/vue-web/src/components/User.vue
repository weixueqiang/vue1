<template>
    <div>
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column  prop="id" label="标识"  width="180"></el-table-column>
        <el-table-column prop="name" label="姓名" width="180"></el-table-column>
        <el-table-column  prop="age" label="年龄"  width="180"></el-table-column>
        <el-table-column prop="sex" label="性别" width="180"></el-table-column>
        <el-table-column  prop="createTime" label="日期"  width="180"></el-table-column>
      </el-table>
    </div>
</template>
<script type="text/ecmascript-6">
//  Vue.http.options.root = '192.168.99.54:8090/user/';
    export default {
        data(){
            return {
              tableData: [{
                createTime: new Date(),
                name: '王小虎',
                id:'1',
                age:12,
                sex:'男'
              }]
            }
        },
      created:function () {
        this.list();
      },
      methods:{
            list(){
              Vue.$http.get('192.168.99.54:8090/user/list').then( (result)=> {
                console.log(result);
              })
            }
      }

    }
</script>
