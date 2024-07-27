// Utility function to toggle class on elements
const toggleClassOnElements = (selector, className) => {
  const elements = document.querySelectorAll(selector);
  elements.forEach(element => element.classList.toggle(className));
}

// Utility function to add class on elements
const addClassOnElements = (selector, className) => {
  const elements = document.querySelectorAll(selector);
  elements.forEach(element => element.classList.add(className));
}

// || Toggle Menu function for hamburger drop down
const toggleNavigation = () => {
  toggleClassOnElements("#user, #teams, #dash, #settings", "drop__menu-icon");

  const bg = document.getElementById("bg");
  bg.classList.toggle("drop-menu-bg");
}

const resetNavigation = () => {
  addClassOnElements("#user, #teams, #dash, #settings", "hide-element");

  const bg = document.getElementById("bg");
  bg.classList.add("hide-element");
}

// || Asthetic function for main home buttons
const moveArrow = () => {
  const a1 = document.getElementById("firstArw");
  const a2 = document.getElementById("secondArw");
  const styleOne = {
      left: "14rem",
      transition: "0.8s ease-in",
      color: "#00bbf3",
      opacity: "100%"
  };
  [a1, a2].forEach(arrow => Object.assign(arrow.style, styleOne));
};
