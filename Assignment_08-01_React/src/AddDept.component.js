import React, { Component } from 'react';

class AddDepartmentComponent extends Component {
    render() {
        return (
            <div style={this.props.divStyle}>
                Dept Name: <input type="text" id="deps"></input>
                <button onClick={() => {
                    this.props.onAdd(document.getElementById("deps").value);
                }}>Add dept</button>
            </div>
        );
    }
}

export default AddDepartmentComponent;