import React, { Component } from 'react';

class ListEmployeeComponent extends Component {
    state = {
        dept: null
    }

    handleList = (data) => {
        this.setState({
            dept: data
        });
    }

    render() {
        return (
            <div style={this.props.divStyle}>
                List from <select id="dep" onChange={() => {
                    this.handleList(document.getElementById("dep").value)
                }}>
                    <option value="all" defaultValue>All</option>
                    {
                        this.props.depts &&
                        this.props.depts.map((dep, i) => {
                            return (
                                <option key={i} value={dep}>{dep}</option>
                            );
                        })
                    }
                </select> department
                {
                    <React.Fragment>
                        <table>
                            {
                                this.props.emps &&
                                this.props.emps.filter((emp) => {
                                    if (this.state.dept == "all") {
                                        return true;
                                    } else {
                                        return emp.dept == this.state.dept;
                                    }
                                }).map((emp, i) => {
                                    if (emp.dept == this.state.dept || this.state.dept == "all") {
                                        return (
                                            <tr key={i}>
                                                <td>{emp.fname}</td>
                                                <td>{emp.lname}</td>
                                                <td>{emp.age}</td>
                                                <td>{emp.dept}</td>
                                            </tr>);
                                    }
                                })
                            }
                        </table>
                    </React.Fragment>
                }
            </div>
        );
    }
}

export default ListEmployeeComponent;