
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
    const commonStyles = {
        left: "16rem",
        transition: "0.8s ease-in",
        color: "#99ffcc",
        opacity: "100%"
    };
    Object.assign(a1.style, commonStyles);
    Object.assign(a2.style, commonStyles);
};

const openForm = () => {
    document.getElementById("login").style.display = "block";
  }
  
  const closeForm = () => {
    document.getElementById("login").style.display = "none";
  }