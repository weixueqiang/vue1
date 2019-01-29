<template>
  <div id="hand">
      <div  id="test">
        <div id="login">
          <el-tabs v-model="activeName" @tab-click="handleClick" type="border-card">
          <el-tab-pane label="用户登录" name="first">
            <div id="loginform">
              <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="姓名" prop="username">
                  <el-input v-model="ruleForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                  <el-input type="password" v-model="ruleForm.password"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                  <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
              </el-form>
            </div>
          </el-tab-pane>
          <el-tab-pane label="用户注册" name="second">
            <div>
              <template id="register">
                <el-form :model="regForm" :rules="regRules" ref="regForm" label-width="100px" class="demo-ruleForm">
                  <el-form-item label="姓名" prop="username">
                    <el-input v-model="regForm.username"></el-input>
                  </el-form-item>
                  <el-form-item label="年龄" prop="age">
                    <el-input v-model="regForm.age"></el-input>
                  </el-form-item>
                  <el-form-item label="性别" prop="sex">
                    <el-select v-model="regForm.sex" placeholder="请选择性别">
                      <el-option label="男" value="男"></el-option>
                      <el-option label="女" value="女"></el-option>
                    </el-select>
                  </el-form-item>

                  <el-form-item>
                    <el-button type="primary" @click="submitregForm('regForm')">保存</el-button>
                    <el-button @click="resetForm('regForm')">重置</el-button>
                  </el-form-item>
                </el-form>
              </template>
            </div>
          </el-tab-pane>
        </el-tabs>
        </div>
      </div>

  </div>
</template>

<script>
//  import test from './js/test.js'
  export default {
    data() {
      return {
        activeIndex: '1',
        logined:false,
        activeName: 'first',
        ruleForm:{username:'',password:''},
        regForm:{username:'',age:'',sex:''},
        rules: {
          username: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
            {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        },
        regRules: {
          username: [
            {required: true, message: '请输入姓名', trigger: 'blur'},
            {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
          ],
          age: [
            {required: true, message: '请输入年龄', trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClick(tab, event) {
        console.log(tab, event);
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            console.log('失败了');
            return false;
          }
        });
        console.log(this.$refs[formName].$el);
        this.$http.post('login',this.ruleForm).then(result=>{
          let body = result.body;
          if(body.succee){
            console.log("登录成功!");
//            this.logined=true;
            window.location.href=('#/center/hello');
          }else {
            this.$message.error(body.msg);
          }
        })
      },
      submitregForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            console.log('失败了');
            return false;
          };
          this.$http.post('save',this.regForm).then(obj=>{
            var body = obj.body;
            if(body.succee){
              this.$message({
                message: '恭喜你，注册成功',
                type: 'success'
              });
              this.activeName='first';
            }else{
              this.$message.error(body.msg);
            }
          })

        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
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
  #login{
    width: 400px;
    height: 400px;
    position: absolute;
    top:200px;
    right:200px;
  }
  #login .el-tabs__item{
    width:200px;
    text-align: center;
  }
  .demo-ruleForm{
    height: 226px;
  }
  #login .el-form-item__label{
    width: 50px;
    padding-right: 20px;
  }
  #login  .el-form-item__content{
    margin-right: 30px;
  }
  #loginform{
    padding-top: 40px;
  }
  #test{
    background: url("../js/a.jpg") no-repeat;
    background-size: cover;
    /*background-repeat:no-repeat;*/
    position: fixed;
    width: 100%;
    height: 100%;
  }
</style>
