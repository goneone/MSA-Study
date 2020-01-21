<template>
<div class="col-md-12">
  <div class="card card-container">
    <img id="profile-img" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" class="profile-img-card" />
    <form name="form">
      <div class="form-group">
        <label for="username">email</label>
        <input type="text" class="form-control" name="username" v-model="username"/>

      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" v-model="password"/>

      </div>
      <div class="form-group">
        <button v-on:click="requestLogin" class="btn btn-primary btn-block" :disabled="loading">
          <span class="spinner-border spinner-border-sm" v-show="loading"></span>
          <span>Sign In</span>
        </button>
      </div>
      <div class="form-group">
        <div class="alert alert-danger" role="alert" v-if="message">{{message}}</div>
      </div>
    </form>
  </div>
</div>
</template>

<script>
import axios from 'axios' // 아까 받은 axios 패키지를 사용하기 위해 import한다

export default {
  name: 'login',
  data() {
    return {
      username:'',
      email: '',
      password: ''
    }
  },
  methods: {
    requestLogin(e) {
      e.preventDefault();
      let form = new FormData();
      form.append('username', this.username);
      form.append('password', this.password);

      axios.post('http://localhost:8081/login', form)
      .then(response => {
        console.warn(response)
        if(response) {
          this.$router.push('/');
        }
      }).catch((ex) => {
        console.warn("ERROR!!!!! : ",ex)
      })

      // axios.post('http://localhost:8081/login',
      // { username : this.username,
      //   email : this.email,
      //   password : this.password
      // })
      // .then(response => {
      //   console.warn(response)
      // }).catch((ex) => {
      //   console.warn("ERROR!!!!! : ",ex)
      // })



      // let form = new FormData();
      // form.append('username', member.email);
      // form.append('password', member.password);
      // form.append("grant_type", "password");
      // const requestData = {
      //   url: `localhost:8081/login`,
      //   method: "POST",
      //   data:form
      // }
      // return axios(requestData);
    }
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
