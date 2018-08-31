import React from 'react';
import ReactDOM from 'react-dom';
import Header from "./Header";
import ProjectsBody from "./ProjectsBody";

export default class App extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Header/>
                <ProjectsBody/>
            </div>
        )
    }
}
