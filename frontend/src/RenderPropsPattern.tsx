import { faker } from "@faker-js/faker";

interface Company {
    companyName: string;
    phrase: string;
}

interface RpsItemProps {
    company: Company;
}

interface RpsListProps {
    list: Array<Company>;
    render: (company: Company) => JSX.Element;
}

const DUMMY_COMPANY_LIST = Array.from({ length: 5 }, () => {
  return {
    companyName: faker.company.name(),
    phrase: faker.company.catchPhrase()
  };
});

function RpsItem({ company }: RpsItemProps ) {
  return (
    <li>
      <p>{company.companyName}</p>
      <p>{company.phrase}</p>
    </li>
  );
}

function RpsList({ list, render }: RpsListProps) {
  return <div>{<ul className="list">{list.map(render)}</ul>}</div>;
}

export default function RenderPropsPattern() {
  return (
    <div>
      <div>render props pattern</div>
      <RpsList
        list={DUMMY_COMPANY_LIST}
        render={(data: Company) => {
            return (
              <RpsItem
                key={data.companyName}
                company={data}
              />
            );
          }}
        />
    </div>
  );
}
