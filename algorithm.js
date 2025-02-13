// 1. Reverse a string
function reverseString(str) {
    // Split the string into an array of characters, reverse the array, and join it back into a string
    return str.split('').reverse().join('');
}

// 2. Find the second-largest number
function secondLargest(arr) {
    // Initialize variables to store the largest and second-largest numbers
    let largest = -Infinity;
    let secondLargest = -Infinity;
    // Loop through the array
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > largest) {
            // Update second-largest and largest
            secondLargest = largest;
            largest = arr[i];
        } else if (arr[i] > secondLargest && arr[i] !== largest) {
            // Update second-largest if the current element is between largest and second-largest
            secondLargest = arr[i];
        }
    }
    return secondLargest;
}

// 3. Check if the string is a palindrome
function isPalindrome(str) {
    // Convert the string to lowercase
    str = str.toLowerCase();
    // Initialize an empty string to store the reversed string
    let reversedStr = '';
    // Loop through the string in reverse order
    for (let i = str.length - 1; i >= 0; i--) {
        // Add each character to the reversed string
        reversedStr += str[i];
    }
    // Compare the original string with its reverse
    return str === reversedStr;
}

// Example usage:
console.log(reverseString("hello")); // Output: "olleh"
console.log(secondLargest([44, 52, 33, 25, 8])); // Output: 9
console.log(isPalindrome("A man, a plan, a canal, Panama")); // Output: true