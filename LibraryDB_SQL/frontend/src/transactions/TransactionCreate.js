import React from 'react'
import {Create, SimpleForm, TextInput, SelectInput ,DateInput, NumberInput } from 'react-admin'


const dateFormatter = v => {
    // v is a `Date` object
    if (!(v instanceof Date) || isNaN(v)) return;
    const pad = '00';
    const yy = v.getFullYear().toString();
    const mm = (v.getMonth() + 1).toString();
    const dd = v.getDate().toString();
    return `${yy}-${(pad + mm).slice(-2)}-${(pad + dd).slice(-2)}`;
  };
  
  const dateParser = v => {
    // v is a string of "YYYY-MM-DD" format
    const match = /(\d{4})-(\d{2})-(\d{2})/.exec(v);
    if (match === null) return;
    const d = new Date(match[1], parseInt(match[2], 10) - 1, match[3]);
    if (isNaN(d)) return;
    return d;
  };


export default function BookCreate(props) {

    return(
        <Create title='Create book' {...props}>
            <SimpleForm>
            <NumberInput source="id" />
                <TextInput source="userId" />
                <TextInput source="employeeId" />
                <TextInput source="bookId" />
                <DateInput source="rentDate" format={dateFormatter} parse={dateParser} />
                <DateInput source="datePlanningReturn" format={dateFormatter} parse={dateParser} />
            </SimpleForm>
        </Create>
    );
}