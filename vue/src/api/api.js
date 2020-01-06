import axios from 'axios'

const config = {
    baseUrl: 'http://localhost:8081'
};

function registerTest() {
    //return axios.post(`${config.baseUrl}/api/members/join`, member);
    return axios.get(`${config.baseUrl}/registerTest`)
      .then(response => {console.log(response);})
      .catch( error => { console.log(error);});
    ;
}

function requestLogin(member) {
    let form = new FormData();
    form.append('username', member.email);
    form.append('password', member.password);
    form.append("grant_type", "password");
    const requestData = {
        url: `${config.baseUrl}/oauth/token`,
        method: "POST",
        auth: {
            username: process.env.VUE_APP_CLIENTID,
            password: process.env.VUE_APP_CLIENTSECRET,
        },
        data: form
    };
    return axios(requestData);
}

export {requestJoinMember, requestLogin, setAccessTokenInHeader}
