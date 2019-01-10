import React, { Component } from 'react';
import './App.css';

import EmployeeComponent from './Emp.component';
import DepartmentComponent from './Dept.component';

class App extends Component {
    state = {
        emps: [],
        depts: [],
        show: false
    }

    constructor() {
        super();

        this.onAddEmpHandler = this.onAddEmpHandler.bind(this);
        this.onAddDeptHandler = this.onAddDeptHandler.bind(this);
    }

    onAddEmpHandler(data) {
        let temp = [...this.state.emps];
        temp.push(data);
        this.setState({
            emps: temp
        });
    }

    onAddDeptHandler(data) {
        let temp = [...this.state.depts];
        temp.push(data);
        this.setState({
            depts: temp
        });
    }

    render() {
        const divStyle = {
            border: "1px solid black",
            padding: "10px",
            margin: "0% 30% 0% 30%",
            textAlign: "center"
        };
        return (
            <React.Fragment>
                <center>
                    <h1>Employee component</h1>
                    <EmployeeComponent onAdd={this.onAddEmpHandler} emps={this.state.emps} depts={this.state.depts} divStyle={divStyle}></EmployeeComponent>
                    <br></br>
                    <h1>Department Component</h1>
                    <DepartmentComponent onAdd={this.onAddDeptHandler} depts={this.state.depts} divStyle={divStyle}></DepartmentComponent>
                </center>
            </React.Fragment>
        );
    }
}

export default App;
