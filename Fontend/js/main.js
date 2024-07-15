
// TOGGLE MENU
const toggleNavigation = () => {
    const elements = document.querySelectorAll("#user, #teams, #dash, #settings");
    elements.forEach(element => element.classList.toggle("drop__menu-icon"));
    
    const bg = document.getElementById("bg");
    bg.classList.toggle("drop-menu-bg");
}

const resetNavigation = () => {
    const elements = document.querySelectorAll("#user, #teams, #dash, #settings");
    elements.forEach(element => element.classList.add("hide-element"));

    const bg = document.getElementById("bg");
    bg.classList.add("hide-element");
}

// BUTTON ARROWS
const moveArrow = () => {
    const a1 = document.getElementById("firstArrow");
    const a2 = document.getElementById("secondArrow");
    const styleOne = {
        left: "14rem",
        transition: "0.8s ease-in",
        color: "#00bbf3",
        opacity: "100%"
    };
    Object.assign(a1.style, styleOne);
    Object.assign(a2.style, styleOne);
};

// LOGIN 

const openLoginPopup = () => {
    document.getElementById("loginContainer").style.display = "none";
    document.getElementById("loginPopup").style.display = "block";
  }
  
  const closeLoginPopup = () => {
    document.getElementById("loginPopup").style.display = "none";
    document.getElementById("loginContainer").style.display = "flex";
  }

// //   Hamburger Menu Effect
// const ringEffect = () => {
//    const ringOne = document.getElementById("ringOne");
//    const ringTwo = document.getElementById("ringTwo");
//     const effectOne =  {
//         opacity: "50%",
//         transition: "1s ease-in-out",
//         transform: "rotateY(360deg)"
//     };
//     const effectTwo = {
//         opacity: "50%",
//         transition: "1s ease-in-out",
//         transform: "rotateY(-360deg)"
//     };
// Object.assign(ringOne, effectOne);
// Object.assign(ringTwo, effectTwo);
// }