import React, { Component } from 'react';

import AddDepartmentComponent from './AddDept.component';
import ListDepartmentComponent from './ListDept.component';

class Department extends Component {
    render() {
        return (
            <React.Fragment>
                <AddDepartmentComponent onAdd={this.props.onAdd} divStyle={this.props.divStyle}></AddDepartmentComponent><br></br>
                <ListDepartmentComponent depts={this.props.depts} divStyle={this.props.divStyle}></ListDepartmentComponent>
            </React.Fragment>
        );
    }
}

export default Department;