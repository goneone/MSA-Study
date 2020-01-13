<template>
  <!-- 목록 출력 영역 -->
    <table class="table table-horizontal table-bordered">
        <thead class="thead-strong">
            <tr>

                <th>제목</th>
                <th>작성자</th>
                <th>최종수정일</th>
            </tr>
        </thead>
        <tbody id="tbody">
            <tr v-for="postData in datas" :key="postData.id">
                <td>{{postData.title}}</td>
                <td>{{postData.author}}</td>
                <td>{{postData.modifiedDate}}</td>
            </tr>
        </tbody>
    </table>
</template>

<script>
  import axios from 'axios' // 아까 받은 axios 패키지를 사용하기 위해 import한다
  export default {
    //el : '#app2',
    mounted: function(){
        const baseURI = 'http://localhost:8081';
        axios.get(`${baseURI}/getPostList`)
        .then((result) => {
        console.log(result)
        this.datas = result.data
        console.log(this.datas)
        }
      )},
    data() {
      return {
        datas: [this.datas]
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
