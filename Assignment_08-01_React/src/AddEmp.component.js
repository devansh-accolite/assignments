import React, { Component } from 'react';

class AddEmployeeComponent extends Component {
    state = {
        showForm: false
    }

    handleAdd = () => {
        this.setState({
            showForm: !this.state.showForm
        })
    }

    render() {
        return (
            <div style={this.props.divStyle}>
                <button onClick={this.handleAdd}>Add Employees</button><br></br>
                {
                    this.state.showForm &&
                    <React.Fragment>
                        First Name: <input type="text" id="fname"></input><br></br>
                        Last Name: <input type="text" id="lname"></input><br></br>
                        Age: <input type="number" id="age"></input><br></br>
                        Department: <select id="dept">
                            <option value="all" defaultValue>-</option>
                            {
                                this.props.depts &&
                                this.props.depts.map((dep, i) => {
                                    return (
                                        <option key={i} value={dep}>{dep}</option>
                                    );
                                })
                            }
                        </select><br></br>
                        <button onClick={() => {
                            if (document.getElementById("age").value < 18) {
                                alert("Age below 18")
                            } else {
                                this.props.onAdd({
                                    fname: document.getElementById("fname").value,
                                    lname: document.getElementById("lname").value,
                                    age: document.getElementById("age").value,
                                    dept: document.getElementById("dept").value
                                })
                            }
                        }}>Add</button>
                        <button onClick={this.handleAdd}>Clear</button>
                    </React.Fragment>
                }
            </div>
        );
    }
}

export default AddEmployeeComponent;