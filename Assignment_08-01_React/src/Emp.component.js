import React, { Component } from 'react';

import AddEmployeeComponent from './AddEmp.component';
import ListEmployeeComponent from './ListEmp.component';

class EmployeeComponent extends Component {
    render() {
        return (
            <React.Fragment>
                <AddEmployeeComponent onAdd={this.props.onAdd} depts={this.props.depts} divStyle={this.props.divStyle}></AddEmployeeComponent><br></br>
                <ListEmployeeComponent emps={this.props.emps} depts={this.props.depts} divStyle={this.props.divStyle}></ListEmployeeComponent>
            </React.Fragment>
        );
    }
}

export default EmployeeComponent;