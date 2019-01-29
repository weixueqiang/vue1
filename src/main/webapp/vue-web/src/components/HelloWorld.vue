<template>
  <div>
    <div id="left">
      <el-tree
        :data="data2"
        node-key="id"
        :default-expand-all="true"
        @node-click="get"
        :props="defaultProps">
      </el-tree>
    </div>
    <div id="center">
      <el-row>
        <el-button type="primary" @click="add">新增</el-button>
      </el-row>
      <div id="formId">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <input type="hidden" v-model="ruleForm.id" name="id"/>
          <el-form-item label="父级名称" prop="parentName">
            <el-input v-model="ruleForm.parentName" readonly></el-input>
          </el-form-item>
          <el-form-item label="名称" prop="name">
            <el-input v-model="ruleForm.name" ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">保存</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <el-dialog title="用户编辑" :visible.sync="dialogFormVisible">
      <el-form :model="ruleForm2" :rules="rules" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
        <input type="hidden" v-model="ruleForm2.parentId" name="parentId"/>
        <el-form-item label="父级名称" prop="parentName">
          <el-input v-model="ruleForm2.parentName" readonly></el-input>
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="ruleForm2.name" ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm2('ruleForm2')">保存</el-button>
          <el-button @click="resetForm('ruleForm2')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>


  </div>

</template>
<script>
  export default {
    data() {
      return {
        dialogFormVisible:false,
        data2: [
        ],
        defaultProps: {
          children: 'children',
          label: 'name'
        },
        ruleForm: {
          id:'',
          parentName: '',
          name: '',
        },
        ruleForm2: {
          parentId:this.parentId,
          parentName: '',
          name: '',
        },
        rules: {
          name: [
            { required: true, message: '请输入名称', trigger: 'blur' },
            { min: 2, max: 20, message: '长度在 2 到 20 个字符', trigger: 'blur' }
          ]
        },
        parentId:''
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
            this.get(this.data2[0],'','')
          }else{
            this.$message.error(body.msg);
          }
        })
      },
      add(){
          this.dialogFormVisible=true;
        this.$http.get('resource/get?id='+this.parentId).then(obj=>{
          let body = obj.body;
          if(body.succee){
            console.log(body.data);
            this.ruleForm2.parentId=body.data.id;
            this.ruleForm2.parentName=body.data.name;

          }else{
            this.$message.error(body.msg);
          }
        })
      },
      get(item,node,obj){
        this.parentId=item.id;
       this.$http.get('resource/get?id='+item.id).then(obj=>{
         let body = obj.body;
         if(body.succee){
           console.log(body.data);
           this.ruleForm.id=body.data.id;
           this.ruleForm.parentName=body.data.parentName;
           this.ruleForm.name=body.data.name;
         }else{
           this.$message.error(body.msg);
         }
       })
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            console.log('失败了');
            return false;
          }
          this.save(this.ruleForm);
        });
      },
      submitForm2(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            console.log('失败了');
            return false;
          }
          this.save(this.ruleForm2);
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      save(data){
        this.$http.post('resource/save',data).then(obj=>{
          let body = obj.body;
          if(body.succee){
            console.log(body.data);
            this.dialogFormVisible=false;
            this.ruleForm2={
              parentId:this.parentId,
                parentName: '',
                name: '',
            };
            this.list();
          }else{
            this.$message.error(body.msg);
          }
        })
      }

    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #left{
   /* border: solid 1px red;*/
    width: 20%;
    height: 100%;
    float: left;
    background-color: #6f7180 ;
  }

  #center{
    float: left;
    /*border: solid 1px blue;*/
    height: 100%;
    width: 80%;

  }
  #formId{
    width: 600px;
    padding-top: 80px;
    padding-left: 0px;
    padding-right: 0px;

  }
  #left .el-tree-node__label{
    font-size: 18px !important;
  }
  .el-tree{
    background-color:#999999;
  }


</style>
