document.addEventListener("DOMContentLoaded", () => {
  console.log("DOM fully loaded and parsed");

  const form = document.getElementById("loginForm");
  console.log("Form element:", form);

  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission

    // Get the values of the fields
    const firstName = document.getElementById("_firstName").value;
    const lastName = document.getElementById("_lastName").value;
    const email = document.getElementById("_email").value;
    const password = document.getElementById("_password").value;
    const confirmPassword = document.getElementById("_confirmPassword").value;

    // Validate password
    const validatePassword = () => {
      if (password !== confirmPassword) {
        document
          .getElementById("_confirmPassword")
          .setCustomValidity("Passwords don't match, please try again.");
      } else {
        document.getElementById("_confirmPassword").setCustomValidity("");
      }
    };

    // Run validation
    validatePassword();

    if (form.checkValidity()) {
      console.log("Form submit event triggered");
      console.log("Form submitted!", {
        firstName,
        lastName,
        email,
        password,
        confirmPassword,
      });

      // You can use fetch or XMLHttpRequest to submit form data to the server
      fetch("http://127.0.0.1:8080/register", {
        // Adjust the URL if needed
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          firstName,
          lastName,
          email,
          password,
          confirmPassword,
        }),
      })
        .then((response) => {
          if (response.ok) {
            return fetch("http://127.0.0.1:8080/team", {
              method: "POST",
              // Add body if needed
            });
          }
        })
        .then((response) => response.json())
        .then((data) => {
          console.log("Success:", data);
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    } else {
      console.warn("Form not submitted, validation failed.");
    }
  });
});

const showLoginForm = () => {
  document.getElementById("loginForm").innerHTML = `
  <h3 class="login__text anton__sc--regular">Log!n</h3>
  <label class="input__label gruppo__regular" for="_email">Email:</label>
  <input class="input__field" id="_email" name="_email" type="email" required />
  
  <label class="input__label gruppo__regular" for="_password">Password:</label>
  <input class="input__field" id="_password" name="_password" type="password" required />
  
  <button class="popup__button popup__button--submit anton__sc--regular" type="submit">Submit</button>
  <button class="popup__button popup__button--close anton-_sc--regular" type="button" onclick="closeLoginPopup()">Close</button>
  <a class="register__link gruppo__regular" href="#" onclick="showRegistrationForm()">Create Prof!le?</a>
  `;
};

const showRegistrationForm = () => {
  document.getElementById("loginForm").innerHTML = `
    <h3 class="login__text anton__sc--regular">Register</h3>
    <label class="input__label gruppo__regular" for="_firstName">First Name:</label>
    <input class="input__field" id="_firstName" name="_firstName" type="text" required />

    <label class="input__label gruppo__regular" for="_lastName">Last Name:</label>
    <input class="input__field" id="_lastName" name="_lastName" type="text" required />
    
    <label class="input__label gruppo__regular" for="_email">Email:</label>
    <input class="input__field" id="_email" name="_email" type="email" required />
    
    <label class="input__label gruppo__regular" for="_password">Password:</label>
    <input class="input__field" id="_password" name="_password" type="password" required />
    
    <label class="input__label gruppo__regular" for="_confirmPassword">Confirm Password:</label>
    <input class="input__field" id="_confirmPassword" name="_confirmPassword" type="password" required />
    
    <button class="popup__button popup__button--submit anton__sc--regular" type="submit">Submit</button>
    <button class="popup__button popup__button--close anton__sc--regular" type="button" onclick="closeLoginPopup()">Close</button>
    <a class="register__link gruppo__regular" href="#" onclick="showLoginForm()">Already have an account?</a>
    `;
};

const openLoginPopup = () => {
  document.getElementById("loginForm").style.display = "block";
  document.getElementById("homeBtns").style.display = "none";
  document.getElementById("emblem").style.display = "none";
};

const closeLoginPopup = () => {
  document.getElementById("loginForm").style.display = "none";
  document.getElementById("homeBtns").style.display = "flex";
  document.getElementById("emblem").style.display = "block";
};
