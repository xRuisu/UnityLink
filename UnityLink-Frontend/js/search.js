document
  .getElementById("searchForm")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission
    const query = document.getElementById("searchInput").value;

    // Use JavaScript to send the request asynchronously to the backend
    fetch(`http://localhost:8080/search?query=${query}`)
      .then((response) => response.json())
      .then((data) => {
        // Handle the data returned from the Spring backend (e.g., update the UI)
        console.log(data);
        // You can dynamically update the page with the search results here
      });
  });
