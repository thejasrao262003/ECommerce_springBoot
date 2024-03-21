// Function to handle the click event of the "+" button
document.getElementById("add-product-btn").addEventListener("click", function() {
    // Toggle display of the product form
    var productForm = document.getElementById("product-form");
    if (productForm.style.display === "none") {
        productForm.style.display = "block";
    } else {
        productForm.style.display = "none";
    }
});

// Function to handle form submission
document.getElementById("product-form").addEventListener("submit", function(event) {
    event.preventDefault();

    var productName = document.getElementById("productName").value;
    var price = parseFloat(document.getElementById("price").value);
    var description = document.getElementById("description").value;


    var product = {
        productName: productName,
        price: price,
        description: description
    };
    console.log("Product data:", product);

    // Add the product details to the product container
    addProduct(product);

    // Clear the form fields
    document.getElementById("productName").value = "";
    document.getElementById("price").value = "";
    document.getElementById("description").value = "";

    // Hide the product form after submission
    document.getElementById("product-form").style.display = "none";

    // Send form data to server
    fetch('/submitProduct', {
        method: 'POST',
        body: JSON.stringify(product), // Convert product object to JSON string
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.text())
        .then(data => {
            console.log(data); // Print response from server
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

function addProduct(product) {
    var productDiv = document.createElement("div");
    productDiv.classList.add("product");
    productDiv.innerHTML = `
        <h2>${product.productName}</h2>
        <p><strong>Price:</strong> $${product.price.toFixed(2)}</p>
        <p><strong>Description:</strong> ${product.description}</p>
    `;
    document.getElementById("product-container").appendChild(productDiv);
}
