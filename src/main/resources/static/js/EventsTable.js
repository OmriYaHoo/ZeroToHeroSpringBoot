import React, {Component} from 'react';
import TimeAgo from 'react-timeago';

export default class EventsTable extends Component {

    constructor(props) {
        super(props);

    }

    render() {
        return (
            <table className="table is-hoverable is-fullwidth">
                <thead>
                <th>Actor</th>
                <th>Action</th>
                <th>Issue title</th>
                <th>Time</th>
                </thead>
                <tbody>
                {this.props.entry.events.map(event => {
                    return (
                        <tr>
                            <td><a href={event.actor.htmlUrl}>{event.actor.login}</a></td>
                            <td><code>{event.type}</code></td>
                            <td>
                                <span /*data-th-if="${event.issue}"*/>
                                    {event.issue && <a href={event.issue.htmlUrl}>{event.issue.title}</a>}
                                </span>
                            </td>
                            <td>
                                <TimeAgo date={event.creationTime}/*data-th-attr="datetime=${event.creationTime}"*//>
                            </td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
        );
    }
}
