<template>
<div class="col-md-12">
  <div class="card card-container">
    <img id="profile-img" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" class="profile-img-card" />
    <form name="form">

      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" name="username" v-model="username" />

      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email" v-model="email" />

      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" v-model="password"/>
      </div>
      <div class="form-group">
        <button v-on:click="registerTest" class="btn btn-primary btn-block" color="default-color">Sign Up</button>
      </div>
    </form>
  </div>
</div>
</template>

<script>
import axios from 'axios' // 아까 받은 axios 패키지를 사용하기 위해 import한다


export default {
  mounted() {
    console.log("Component mounted")
  },
  name: 'app',
  data() {
    return {
      username: '',
      email: '',
      password: ''
    };
  },
  methods: {
    // getData: function(){
    //   alert("시작합니다")
    //   axios.get('http://localhost:8081/registerTest')
    //   .then(function(response){
    //       alert("데이터 받아옵니다")
    //       alert(response)
    //   });
    // }
    registerTest(e) {
      alert("회원가입")
      e.preventDefault(); //현재 이벤트의 기본 동작을 중단한다.
      axios.post('http://localhost:8081/register',
        { username  : this.username,
          email     : this.email,
          password  : this.password
        })
        .then(response => {
          console.warn(response)
          this.result = response.data
          this.no = response.data.no
      }).catch((ex) => {
          console.warn("ERROR!!!!! : ",ex)
      })
    },
  }
}
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}

.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>
