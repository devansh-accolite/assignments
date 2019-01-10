import React, { Component } from 'react';

class ListDepartmentComponent extends Component {
    render() {
        const ulAlign = {
            textAlign: "center",
            listStylePosition: "inside"
        }
        return (
            <div style={this.props.divStyle}>
                Department List
                <ul style={ulAlign}>
                    {
                        this.props.depts &&
                        this.props.depts.map((dep, i) => {
                            return (
                                <li style={ulAlign}>{dep}</li>
                            );
                        })
                    }
                </ul>
            </div>
        );
    }
}

export default ListDepartmentComponent;