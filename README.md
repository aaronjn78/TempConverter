# Temperature converter
Basic app to automatically convert from one unit of temperature to the other two units automtically

## Goals
- Practice creating basic GUIs using Java AWT
- Practice utilizing event handling techniques
- Practice error handling

## Steps/Updates

1. Created basic GUI with text fields and labels
	- considered implementing use of buttons, either a single convert button to trigger the conversion, or multiple buttons to trigger the conversion from the changed unit to the to the other two. Decided to implement trigger the conversions through typing events.
2. Added methods to convert between different temperature units
3. Added event listeners to text fields to dynamically check to changes to the text and call conversion methods
4. Looked up and implemented a method to close the application cleanly

### Bugs/Fixes
1. Deleting the text from any of the fields resulted in an "Empty String" message being displayed in the console. Attempting to correct this so no console message displayed.
	- Fix 1: check for empty string using string comparison and return a default string value
	
2. Deleting text in Farenheit or Celsius text field still resulting in "Empty String" message being displayed to console. Does not occur in other text fields.
	- Fix 2: Found the message in the console was an error message when trying to find the double value of the string text. Removed previous fix and added code to check for empty string arguments
	
3. Code does not handle non-numeric or blank entries currently. It still runs, but will generate console error messages

	
