<template>

 <body>
   <div class="bg">
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Start A Tab</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="big-box">
      <div class="box">
      <label for="username" class="sr-only">Username:  </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <div class="box">
      <label for="password" class="sr-only">Password:  </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      </div>
      <div class="box">
      <label for="confirm-password" class="sr-only">Confirm Password:  </label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      </div>
        <div class="lil-box">
       <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>
      <div class="lil-box">
      <router-link :to="{ name: 'login' }" class="center-link">Have an account?</router-link>
      </div>
      </div>
    </form>
  </div>
   </div>
 </body>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
body, html{
  height: 100vh;
}
.bg{
background-image: url(../../public/img/background.jpg);
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  height: 100%;
}
.box{
  display: flex;
  background-color: transparent;
  padding: 5px;
  justify-content: space-between;
}
.big-box {
  background-color: whitesmoke;
  padding: 10px;
  border: 5px solid black;
  border-radius: 5px;
}

.form-register {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
 
}
input:focus {
    outline: none !important;
    border: 3px solid goldenrod;
    border-radius: 5px;
  }
.lil-box {
  display: flex;
  justify-content: space-evenly;
  padding: 5px;
}


h1{
  color: goldenrod;
 text-align: center;
 font-family: Bebas Neue;
 font-size: 75px;
}
</style>
