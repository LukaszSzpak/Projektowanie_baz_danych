import React, { useContext } from 'react'
import {Edit, SimpleForm, TextInput, SelectInput } from 'react-admin'

export default function TransactionEdit(props) {

    return(
        <Edit title='Edit transaction' {...props}>
            <SimpleForm>
                <NumberField source="id" />
                <TextField source="userId" />
                <TextField source="employeeId" />
                <TextField source="bookId" />
                <DateField sourde="rentDate" />
                <DateField sourde="datePlanningReturn" />
            </SimpleForm>
        </Edit>
    );
}