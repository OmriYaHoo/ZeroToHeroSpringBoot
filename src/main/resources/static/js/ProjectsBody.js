import React, {Component} from 'react';
import EventsTable from "./EventsTable";
import axios from "axios/index";

import mock from './mock';

export default class ProjectsBody extends Component {

    constructor() {
        super();

        this.state = {
            entries: []
        }
    }

    componentDidMount() {
        axios.get('/dashboard')
            .then(response => {
                this.setState({entries: response.data});
            })
            .catch(err => {
                console.error(err);
            });
    }

    render() {
        const {entries} = this.state;

        const mainData = entries.map(entry => {
            return (
                <section className="section" key={entry.project.repoName}>
                    <div className="container">
                        <h1 className="title">{entry.project.orgName} / {entry.project.repoName}</h1>
                        <EventsTable entry={entry}/>
                    </div>
                </section>);
        });
        return (
            <div>
                {mainData}
            </div>
        );
    }
}
