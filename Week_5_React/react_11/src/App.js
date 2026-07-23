import CurrencyConvertor from "./CurrencyConvertor";
function App() {
    let count = 0;
    function incrementValue() {
        count++;

       alert("Counter : " + count);

        sayHello();

    }
    function decrementValue() {
        count--;
        alert("Counter : " + count);
    }
    function sayHello() {
        alert("Hello Member");
    }
    function sayWelcome(message) {
        alert(message);

    }
    function onPress() {

        alert("I was clicked");

    }
    return (
        <div>
            <button onClick={incrementValue}>
                Increment
            </button>
            <br />
            <button onClick={decrementValue}>
                Decrement
            </button>
            <br />
            <button
                onClick={() => sayWelcome("Welcome")}
            >
                Say Welcome
            </button>
            <br />
            <button onClick={onPress}>
                Click on me
            </button>
            <br />
            <br />
            <CurrencyConvertor />
        </div>
    );
}
export default App;