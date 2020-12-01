import React from 'react'
import {Create, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function BookCreate(props) {

    return(
        <Create title='Create book' {...props}>
            <SimpleForm>
            <NumberField source="id" />
                <TextField source="userId" />
                <TextField source="employeeId" />
                <TextField source="bookId" />
                <DateField sourde="rentDate" />
                <DateField sourde="datePlanningReturn" />
            </SimpleForm>
        </Create>
    );
}