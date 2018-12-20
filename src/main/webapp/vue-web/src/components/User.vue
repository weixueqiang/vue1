<template>
    <div>
      <el-table :data="tableData" stripe style="width: 100%" >
        <el-table-column  prop="id" label="标识"  width="180"></el-table-column>
        <el-table-column prop="username" label="姓名" width="180"></el-table-column>
        <el-table-column  prop="age" label="年龄"  width="180"></el-table-column>
        <el-table-column prop="sex" label="性别" width="180"></el-table-column>
        <el-table-column  prop="createTime"  :formatter="formatDate" label="日期"  width="180"></el-table-column>
      </el-table>
    </div>
</template>
<script type="text/ecmascript-6">

  import Vue from 'vue'


  Vue.filter('format',function (dateStr) {
    let date = new Date(dateStr);
    console.log(date.getFullYear()+"...");
    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDay();
  })

    export default {
        data(){
            return {
              tableData: [{
                createTime: new Date(),
                username: '王小虎',
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
              this.$http.get('list').then( (result)=> {
                // console.log(JSON.stringify(result))
                let body = result.body;
                if(body.succee){
                  this.tableData=body.data;
                }else {
                  alert("wrong");
                }
              })
            },
        formatDate(row, column, cellValue, index) {
            let date = new Date(cellValue);
            return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDay()+" "+date.getHours()+":"+date.getMinutes();
         }

      }

    }
</script>
