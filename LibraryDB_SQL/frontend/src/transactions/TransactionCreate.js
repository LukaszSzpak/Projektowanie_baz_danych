import React from 'react'
import {Create, SimpleForm, TextInput, SelectInput ,DateInput, NumberInput } from 'react-admin'

export default function BookCreate(props) {

    return(
        <Create title='Create book' {...props}>
            <SimpleForm>
            <NumberInput source="id" />
                <TextInput source="userId" />
                <TextInput source="employeeId" />
                <TextInput source="bookId" />
                <DateInput sourde="rentDate" />
                <DateInput sourde="datePlanningReturn" />
            </SimpleForm>
        </Create>
    );
}