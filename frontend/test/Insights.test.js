// Link.react.test.js
import React from 'react';
import Insights from '../src/components/Insights';
import renderer from 'react-test-renderer';
import Enzyme, { shallow } from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

test('Draw Insights component', () => {  
  const data = {clicks: '100', kpi1: '1.0'}
  const component = renderer.create(<Insights data={data} />,
  );
  let dialog = component.toJSON();
  expect(dialog).toMatchSnapshot();  
});
