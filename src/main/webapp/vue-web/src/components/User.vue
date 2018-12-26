<template>
    <div >
      <el-row>
        <el-button type="primary" @click="add">新增</el-button>
      </el-row>
      <el-table :data="tableData" stripe style="width: 100%" >
        <el-table-column  prop="id" label="标识"  width="180"></el-table-column>
        <el-table-column prop="username" label="姓名" width="180"></el-table-column>
        <el-table-column  prop="age" label="年龄"  width="180"></el-table-column>
        <el-table-column prop="sex" label="性别" width="180"></el-table-column>
        <el-table-column  prop="createTime"  :formatter="formatDate" label="日期"  width="180"></el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="edit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>


      <!-- Form -->
      <!--<el-button type="text" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>-->

      <el-dialog title="用户编辑" :visible.sync="dialogFormVisible">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <input type="hidden" v-model="ruleForm.id" name="id"/>
          <el-form-item label="姓名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input v-model="ruleForm.age"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-select v-model="ruleForm.sex" placeholder="请选择性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">保存</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
</template>

<script type="text/ecmascript-6">

//  import Vue from 'vue'
//
//
//  Vue.filter('format',function (dateStr) {
//    let date = new Date(dateStr);
//    console.log(date.getFullYear()+"...");
//    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDay();
//  })
import test from '../js/test.js'

    export default {
        data(){
            return {
              tableData: [],
              formLabelWidth: '120px',
              dialogFormVisible: false,
              ruleForm: {
                id:'',
                username: '',
                age: '',
                sex: ''
              },
              rules: {
                username: [
                  { required: true, message: '请输入姓名', trigger: 'blur' },
                  { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
                ],
                sex: [
                  { required: true, message: '请选择性别', trigger: 'change' }
                ] ,
                age: [
                  { required: true, message: '请输入年龄', trigger: 'blur' }
                ]

              }
            };
        },
      created:function () {
        this.list();
      },
      methods:{
            list(){
              this.$http.get('list').then( (result)=> {
//                  test.errmsg(this,'全局js错误信息!');
                // console.log(JSON.stringify(result))
                let body = result.body;
                if(body.succee){
                  this.tableData=body.data;
                }else {
                  this.$notify({
                    message: body.msg,
                    position: 'top-right',
                    duration:2000,
                  });
                }
              })
            },
//        formatDate
        formatDate:test.formatDate,
//            formatDate(row, column, cellValue, index) {
//                let date = new Date(cellValue);
//                return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDay()+" "+date.getHours()+":"+date.getMinutes();
//             },
//            handleEdit(index,row){
//                    console.log(index,row);
//                    console.log(row.username);
//
//            },
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (!valid) {
              console.log('失败了');
              return false;
            }
            this.$http.post('save',this.ruleForm).then((result)=>{
              let body = result.body;
              if(body.succee){
                this.list();
                this.dialogFormVisible=false;
                this.resetData();
              }else{
                this.$notify({
                  message: body.msg,
                  position: 'top-right',
                  duration:2000,
                });
              }
            })
          });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        },
        edit(index,row){
          this.$message({
            showClose: true,
            message: '全局js错误信息!',
            type: 'error',
            duration:3000
          });
          this.$http.get('get'+"?id="+row.id).then((obj)=>{
            let result = obj.body;
            if(result.succee){
              this.dialogFormVisible=true;
              this.ruleForm.id=result.data.id;
              this.ruleForm.username=result.data.username;
              this.ruleForm.sex=result.data.sex;
              this.ruleForm.age=result.data.age;
            }else {
              this.$notify({
                message: result.msg,
                position: 'top-right',
                duration:2000,
              });
            }
          })
        },
        handleDelete(index,row){
          this.$confirm('是否确认删除?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center:true
          }).then(() => {
            this.$http.get('delete?id='+row.id).then((obj)=>{
              let result = obj.body;
              if(result.succee){
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                });
                this.list();
              }else {
                this.$notify({
                  message: result.msg,
                  position: 'top-right',
                  duration:2000,
                });
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });

        },
        resetData(){
          this.ruleForm={
              id:'',
              username: '',
              age: '',
              sex:this.ruleForm.sex,
          }
        },
        add(){
          this.resetData();
          console.log("............")
          this.dialogFormVisible=true;
        }
      }


    }
</script>
<style>

</style>
