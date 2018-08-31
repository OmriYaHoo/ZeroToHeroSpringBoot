import React, {Component} from 'react';

export default class EventsTable extends Component {

    constructor() {
        super();

        this.state = {
            entries: []
        }
    }

    render() {
        const {entries} = this.state;

        entries.map(entry => {
            return (<section className="section">
                
            </section>);
        });

        return (
            <section data-th-each="entry : ${entries}" className="section">
                <div className="container">
                    <h1 className="title">[[${entry.project.orgName}]] / [[${entry.project.repoName}]]</h1>
                    <table className="table is-hoverable is-fullwidth">
                        <thead>
                        <th>Actor</th>
                        <th>Action</th>
                        <th>Issue title</th>
                        <th>Time</th>
                        </thead>
                        <tbody>
                        <tr data-th-each="event : ${entry.events}">
                            <td><a data-th-href="${event.actor.htmlUrl}">[[${event.actor.login}]]</a></td>
                            <td><code>[[${event.type}]]</code></td>
                            <td><span data-th-if="${event.issue}"><a
                                data-th-href="${event.issue.htmlUrl}">[[${event.issue.title}]]</a></span></td>
                            <td>
                                <time data-th-attr="datetime=${event.creationTime}">[[${event.creationTime}]]</time>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        )
            ;
    }
}
