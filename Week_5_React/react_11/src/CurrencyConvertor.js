import React, { Component } from "react";

class CurrencyConvertor extends Component {

    constructor() {
        super();

        this.state = {
            amount: "",
            currency: ""
        };
    }

    handleAmount = (event) => {
        this.setState({
            amount: event.target.value
        });
    };

    handleCurrency = (event) => {
        this.setState({
            currency: event.target.value
        });
    };

    handleSubmit = () => {

        const euro = (this.state.amount / 80).toFixed(2);

        alert(
            "Converting to Euro Amount is " + euro
        );

    };

    render() {

        return (

            <div>

                <h1 style={{ color: "green" }}>
                    Currency Convertor!!!
                </h1>

                <table>

                    <tbody>

                        <tr>

                            <td>Amount:</td>

                            <td>

                                <input
                                    type="number"
                                    value={this.state.amount}
                                    onChange={this.handleAmount}
                                />

                            </td>

                        </tr>

                        <tr>

                            <td>Currency:</td>

                            <td>

                                <input
                                    value={this.state.currency}
                                    onChange={this.handleCurrency}
                                />

                            </td>

                        </tr>

                        <tr>

                            <td></td>

                            <td>

                                <button
                                    onClick={this.handleSubmit}
                                >
                                    Submit
                                </button>

                            </td>

                        </tr>

                    </tbody>

                </table>

            </div>

        );

    }

}

export default CurrencyConvertor;