<template>
    <div id = "app">
       {{ message }}
   </div>
</template>

<script>
  import axios from 'axios' // 아까 받은 axios 패키지를 사용하기 위해 import한다
  export default {
    mounted: function(){
        const baseURI = 'http://localhost:8081/';
        axios.get(`${baseURI}/getPostList`)
        .then((result) => {
        console.log(result)
        this.datas = result.data
        }
      )},
    data() {
      return {
        username: '',
        email: '',
        password: '',
        message: '에라이'
      };
    },
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;

}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.space {
  padding: 20px;
}
</style>
