// auth.js

const openLoginPopup = () => {
    document.getElementById("loginForm").style.display = "block";
    document.getElementById("homeBtns").style.display = "none";
    document.getElementById("emblem").style.display = "none";
  }
  
  const closeLoginPopup = () => {
    document.getElementById("loginForm").style.display = "none";
    document.getElementById("homeBtns").style.display = "flex";
    document.getElementById("emblem").style.display = "block";
  }
  
  const showLoginForm = () => {
    document.getElementById("loginForm").innerHTML = `
      <h3 class="login__text anton__sc--regular">Log!n</h3>
      <label class="input__label gruppo__regular" for="uMail">Email:</label>
      <input class="input__field" id="uMail" name="uMail" type="email" required />
  
      <label class="input__label gruppo__regular" for="uPassword">Password:</label>
      <input class="input__field" id="uPassword" name="uPassword" type="password" required />
  
      <button class="popup__button popup__button--close anton-_sc--regular" type="button" onclick="closeLoginPopup()">Close</button>
      <a class="register__link gruppo__regular" href="#" onclick="showRegistrationForm()">Create Prof!le?</a>
    `;
  }
  
  const showRegistrationForm = () => {
    document.getElementById("loginForm").innerHTML = `
      <h3 class="login__text anton__sc--regular">Register</h3>
      <label class="input__label gruppo__regular" for="uName">Name:</label>
      <input class="input__field" id="uName" name="uName" type="text" required />
  
      <label class="input__label gruppo__regular" for="uMail">Email:</label>
      <input class="input__field" id="uMail" name="uMail" type="email" required />
  
      <label class="input__label gruppo__regular" for="uPassword">Password:</label>
      <input class="input__field" id="uPassword" name="uPassword" type="password" required />
  
      <label class="input__label gruppo__regular" for="uConfirmPassword">Confirm Password:</label>
      <input class="input__field" id="uConfirmPassword" name="uConfirmPassword" type="password" required />
  
      <button class="popup__button popup__button--close anton__sc--regular" type="button" onclick="closeLoginPopup()">Close</button>
      <a class="register__link gruppo__regular" href="#" onclick="showLoginForm()">Already have an account?</a>
    `;
  }
  