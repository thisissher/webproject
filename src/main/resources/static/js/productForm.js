const productsControl = new ProductsController();
var storeImage = ""

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemImageUrl = document.querySelector('#newItemImageFile');
    const newItemStyle = document.querySelector('#newItemStyle');
    const newItemPrice = document.querySelector('#newItemPrice');

    /*
        Do the Validation code here
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const name = newItemNameInput.value;
    const description = newItemDescription.value;

    //For HTML5 spec - a file uploaded to the browser should not reveal the real local
    //path from the user machine based on security. Browser will append a fakepath
    //(C:\fakepath\t-shirt_new.jpg) to the path for the file information
    //console.log(newItemImageUrl.value);

    const imageUrl = newItemImageUrl.value.replace("C:\\fakepath\\", "");
    //imageUrl = t-shirt_new.jpg

    const style = newItemStyle.value;
    const price = newItemPrice.value;

    // Clear the form
    newItemNameInput.value = '';
    newItemDescription.value = '';
    newItemImageUrl.value = '';
    newItemStyle.value = '';
    newItemPrice.value = '';

    // Add the task to the task manager
    productsControl.addItem(name, description, imageUrl, style, price, storeImage);

});

//Get the image object
// select file input
const input = document.querySelector('#newItemImageFile');

// add event listener
input.addEventListener('change', () => {

    storeImage = input.files[0];

});
