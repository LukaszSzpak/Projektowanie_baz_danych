import React, { useContext } from 'react'
import {Edit, SimpleForm, TextInput, SelectInput, DateInput, NumberInput } from 'react-admin'

export default function TransactionEdit(props) {

    return(
        <Edit title='Edit transaction' {...props}>
            <SimpleForm>
                <NumberInput source="id" />
                <TextInput source="userId" />
                <TextInput source="employeeId" />
                <TextInput source="bookId" />
                <DateInput sourde="rentDate" />
                <DateInput sourde="datePlanningReturn" />
            </SimpleForm>
        </Edit>
    );
}