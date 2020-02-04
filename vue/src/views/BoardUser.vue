<template>
  <div class="container">
    <thead class="thead-strong">
      <tr>
        <th>제목</th>
        <th>작성자</th>
        <th>최종수정일</th>
      </tr>

      <h3>{{content}}</h3>
    </thead>
    <tbody id="tbody">
      <tr v-for="postData in datas" :key="postData.id">
          <td>{{postData.title}}</td>
          <td>{{postData.author}}</td>
          <td>{{postData.modifiedDate}}</td>
      </tr>
    </tbody>
  </div>
</template>

<script>
import UserService from '../services/user.service';

export default {
  name: 'User',
  data() {
    return {
      datas: ''
    };
  },
  mounted() { //window.onload와 비슷한 느낌..
    UserService.getUserBoard().then(
      response => {
        this.datas = response.data;
      },
      error => {
        this.datas =
          (error.response && error.response.data) ||
          error.message ||
          error.toString();
      }
    );
  }
};
</script>
